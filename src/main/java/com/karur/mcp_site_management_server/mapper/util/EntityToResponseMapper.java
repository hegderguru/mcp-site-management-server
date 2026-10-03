package com.karur.mcp_site_management_server.mapper.util;

import com.karur.mcp_site_management_server.entity.*;
import com.karur.mcp_site_management_server.model.response.*;
import org.springframework.stereotype.Component;

@Component
public class EntityToResponseMapper {

    public static SiteResponse buildSiteResponse(Site site) {
        return SiteResponse.builder()
                .id(site.getId())
                .identifier(site.getIdentifier())
                .name(site.getName())
                .number(site.getNumber())
                .locationResponse(buildLocationResponse(site.getLocation()))
                .addressResponse(buildAddressResponse(site.getAddress()))
                .ownersResponse(site.getOwners().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .currentRegistrationResponse(buildRegistrationResponse(site.getCurrentRegistration()))
                .build();
    }

    private static RegistrationResponse buildRegistrationResponse(Registration registration) {
        return RegistrationResponse.builder()
                .id(registration.getId())
                .identifier(registration.getIdentifier())
                .registrationDateTime(registration.getRegistrationDateTime())
                .currentOwnerResponses(registration.getCurrentOwners().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .previousOwnerResponses(registration.getPreviousOwners().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .build();
    }

    private static OwnerResponse buildOwnerResponse(Owner owner) {
        return OwnerResponse.builder()
                .id(owner.getId())
                .identity(owner.getIdentity())
                .firstName(owner.getFirstName())
                .middleName(owner.getMiddleName())
                .lastName(owner.getLastName())
                .primaryAddress(buildAddressResponse(owner.getPrimaryAddress()))
                .PermanentAddress(buildAddressResponse(owner.getPermanentAddress()))
                .order(owner.getOrder())
                .build();
    }

    private static AddressResponse buildAddressResponse(Address address) {
        return AddressResponse.builder()
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

    private static LocationResponse buildLocationResponse(Location location) {
        return LocationResponse.builder()
                .id(location.getId())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .border(location.getBorder().stream().map(EntityToResponseMapper::buildLocationResponse).toList())
                .build();
    }

}
