package com.karur.mcp_site_management_server.mapper.util;

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
                .locationRequest(buildLocationRequest(site.getLocation()))
                .addressRequest(buildAddressRequest(site.getAddress()))
                .ownersRequests(site.getOwners().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .currentRegistrationRequest(buildRegistrationRequest(site.getCurrentRegistration()))
                .build();
    }

    private static RegistrationRequest buildRegistrationRequest(Registration registration) {
        return RegistrationRequest.builder()
                .id(registration.getId())
                .identifier(registration.getIdentifier())
                .registrationDateTime(registration.getRegistrationDateTime())
                .currentOwnerRequests(registration.getCurrentOwners().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .previousOwnerRequests(registration.getPreviousOwners().stream().map(EntityToRequestMapper::buildOwnerRequest).toList())
                .build();
    }

    private static OwnerRequest buildOwnerRequest(Owner owner) {
        return OwnerRequest.builder()
                .id(owner.getId())
                .identity(owner.getIdentity())
                .firstName(owner.getFirstName())
                .middleName(owner.getMiddleName())
                .lastName(owner.getLastName())
                .primaryAddress(buildAddressRequest(owner.getPrimaryAddress()))
                .PermanentAddress(buildAddressRequest(owner.getPermanentAddress()))
                .order(owner.getOrder())
                .build();
    }

    private static AddressRequest buildAddressRequest(Address address) {
        return AddressRequest.builder()
                .id(address.getId())
                .number(address.getNumber())
                .name(address.getName())
                .floor(address.getFloor())
                .street(address.getStreet())
                .place(address.getPlace())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pinCode(address.getPinCode())
                .build();
    }

    private static LocationRequest buildLocationRequest(Location location) {
        return LocationRequest.builder()
                .id(location.getId())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .border(location.getBorder().stream().map(EntityToRequestMapper::buildLocationRequest).toList())
                .build();
    }

}
