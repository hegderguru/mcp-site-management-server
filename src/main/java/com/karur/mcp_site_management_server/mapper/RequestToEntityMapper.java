package com.karur.mcp_site_management_server.mapper;

import com.karur.mcp_site_management_server.entity.*;
import com.karur.mcp_site_management_server.model.request.*;
import org.springframework.stereotype.Component;

@Component
public class RequestToEntityMapper {

    public static Site buildSite(SiteRequest siteRequest) {
        return Site.builder()
                .id(siteRequest.getId())
                .identifier(siteRequest.getIdentifier())
                .name(siteRequest.getName())
                .number(siteRequest.getNumber())
                .location(buildLocation(siteRequest.getLocationRequest()))
                .address(buildAddress(siteRequest.getAddressRequest()))
                .owners(siteRequest.getOwnersRequests().stream().map(RequestToEntityMapper::buildOwner).toList())
                .currentRegistration(buildRegistration(siteRequest.getCurrentRegistrationRequest()))
                .build();
    }

    private static Registration buildRegistration(RegistrationRequest registrationRequest) {
        return Registration.builder()
                .id(registrationRequest.getId())
                .identifier(registrationRequest.getIdentifier())
                .registrationDateTime(registrationRequest.getRegistrationDateTime())
                .currentOwners(registrationRequest.getCurrentOwnerRequests().stream().map(RequestToEntityMapper::buildOwner).toList())
                .previousOwners(registrationRequest.getPreviousOwnerRequests().stream().map(RequestToEntityMapper::buildOwner).toList())
                .build();
    }

    private static Owner buildOwner(OwnerRequest ownerRequest) {
        return Owner.builder()
                .id(ownerRequest.getId())
                .identity(ownerRequest.getIdentity())
                .firstName(ownerRequest.getFirstName())
                .middleName(ownerRequest.getMiddleName())
                .lastName(ownerRequest.getLastName())
                .primaryAddress(buildAddress(ownerRequest.getPrimaryAddress()))
                .PermanentAddress(buildAddress(ownerRequest.getPermanentAddress()))
                .order(ownerRequest.getOrder())
                .build();
    }

    private static Address buildAddress(AddressRequest addressRequest) {
        return Address.builder()
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

    private static Location buildLocation(LocationRequest locationRequest) {
        return Location.builder()
                .id(locationRequest.getId())
                .latitude(locationRequest.getLatitude())
                .longitude(locationRequest.getLongitude())
                .border(locationRequest.getBorder().stream().map(RequestToEntityMapper::buildLocation).toList())
                .build();
    }

}
