package com.karur.mcp_site_management_server.mapper;

import com.karur.mcp_site_management_server.entity.*;
import com.karur.mcp_site_management_server.model.request.*;
import org.springframework.stereotype.Component;

@Component
public class EntityToRequestMapper {

    public static SiteRequest buildSiteRequest(Site site) {
        return SiteRequest.builder()
                .id(site.getId())
                .identifier(site.getIdentifier())
                .name(site.getName())
                .number(site.getNumber())
                .locationRequest(buildLocationRequest(site.getLocationEntity()))
                .addressRequest(buildAddressRequest(site.getAddressEntity()))
                .ownersRequests(site.getOwnerEntities().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .currentRegistrationRequest(buildRegistrationRequest(site.getCurrentRegistrationEntity()))
                .build();
    }

    private static RegistrationRequest buildRegistrationRequest(RegistrationEntity registrationEntity) {
        return RegistrationRequest.builder()
                .id(registrationEntity.getId())
                .identifier(registrationEntity.getIdentifier())
                .registrationDateTime(registrationEntity.getRegistrationDateTime())
                .currentOwnerRequests(registrationEntity.getCurrentOwnerEntities().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .previousOwnerRequests(registrationEntity.getPreviousOwnerEntities().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .build();
    }

    private static OwnerRequest buildOwnerRequest(OwnerEntity ownerEntity) {
        return OwnerRequest.builder()
                .id(ownerEntity.getId())
                .identityEntity(ownerEntity.getIdentityEntity())
                .firstName(ownerEntity.getFirstName())
                .middleName(ownerEntity.getMiddleName())
                .lastName(ownerEntity.getLastName())
                .primaryAddress(buildAddressRequest(ownerEntity.getPrimaryAddressEntity()))
                .PermanentAddress(buildAddressRequest(ownerEntity.getPermanentAddressEntity()))
                .order(ownerEntity.getOrder())
                .build();
    }

    private static AddressRequest buildAddressRequest(AddressEntity addressEntity) {
        return AddressRequest.builder()
                .id(addressEntity.getId())
                .number(addressEntity.getNumber())
                .name(addressEntity.getName())
                .floor(addressEntity.getFloor())
                .street(addressEntity.getStreet())
                .place(addressEntity.getPlace())
                .city(addressEntity.getCity())
                .state(addressEntity.getState())
                .country(addressEntity.getCountry())
                .pinCode(addressEntity.getPinCode())
                .build();
    }

    private static LocationRequest buildLocationRequest(LocationEntity locationEntity) {
        return LocationRequest.builder()
                .id(locationEntity.getId())
                .latitude(locationEntity.getLatitude())
                .longitude(locationEntity.getLongitude())
                .border(locationEntity.getBorder().stream().map(EntityToRequestMapper::buildLocationRequest).toList())
                .build();
    }

}
