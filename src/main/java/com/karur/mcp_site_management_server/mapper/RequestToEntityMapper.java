package com.karur.mcp_site_management_server.mapper;

import com.karur.mcp_site_management_server.entity.*;
import com.karur.mcp_site_management_server.model.request.*;
import com.karur.mcp_site_management_server.util.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class RequestToEntityMapper {

    public static SiteEntity buildSite(SiteRequest siteRequest) {
        return SiteEntity.builder()
                .id(siteRequest.getId())
                .identifier(siteRequest.getIdentifier())
                .name(siteRequest.getName())
                .number(siteRequest.getNumber())
                .locationEntity(buildLocation(siteRequest.getLocationRequest()))
                .addressEntity(buildAddress(siteRequest.getAddressRequest()))
                .currentRegistrationEntity(buildRegistration(siteRequest.getCurrentRegistrationRequest()))
                .build();
    }

    private static RegistrationEntity buildRegistration(RegistrationRequest registrationRequest) {
        return RegistrationEntity.builder()
                .id(registrationRequest.getId())
                .identifier(registrationRequest.getIdentifier())
                .registrationDateTime(registrationRequest.getRegistrationDateTime())
                .currentOwnerEntities(CommonUtil.returnElseEmpty(registrationRequest.getCurrentOwnerRequests()).stream().map(RequestToEntityMapper::buildOwner).toList())
                .siteEntities(CommonUtil.returnElseEmpty(registrationRequest.getSiteRequests()).stream().map(RequestToEntityMapper::buildSite).toList())
                .build();
    }

    private static OwnerEntity buildOwner(OwnerRequest ownerRequest) {
        return OwnerEntity.builder()
                .id(ownerRequest.getId())
                .identityEntity(ownerRequest.getIdentityEntity())
                .firstName(ownerRequest.getFirstName())
                .middleName(ownerRequest.getMiddleName())
                .lastName(ownerRequest.getLastName())
                .primaryAddressEntity(buildAddress(ownerRequest.getPrimaryAddress()))
                .permanentAddressEntity(buildAddress(ownerRequest.getPermanentAddress()))
                .order(ownerRequest.getOrder())
                .build();
    }

    private static AddressEntity buildAddress(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .id(addressRequest.getId())
                .number(addressRequest.getNumber())
                .name(addressRequest.getName())
                .floor(addressRequest.getFloor())
                .street(addressRequest.getStreet())
                .place(addressRequest.getPlace())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    private static LocationEntity buildLocation(LocationRequest locationRequest) {
        return LocationEntity.builder()
                .id(locationRequest.getId())
                .latitude(locationRequest.getLatitude())
                .longitude(locationRequest.getLongitude())
                .border(locationRequest.getBorder())
                .build();
    }

}
