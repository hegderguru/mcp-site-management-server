package com.karur.mcp_site_management_server.mapper;

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
                .locationResponse(buildLocationResponse(site.getLocationEntity()))
                .addressResponse(buildAddressResponse(site.getAddressEntity()))
                .ownersResponse(site.getOwnerEntities().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .currentRegistrationResponse(buildRegistrationResponse(site.getCurrentRegistrationEntity()))
                .build();
    }

    private static RegistrationResponse buildRegistrationResponse(RegistrationEntity registrationEntity) {
        return RegistrationResponse.builder()
                .id(registrationEntity.getId())
                .identifier(registrationEntity.getIdentifier())
                .registrationDateTime(registrationEntity.getRegistrationDateTime())
                .currentOwnerResponses(registrationEntity.getCurrentOwnerEntities().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .previousOwnerResponses(registrationEntity.getPreviousOwnerEntities().stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .build();
    }

    private static OwnerResponse buildOwnerResponse(OwnerEntity ownerEntity) {
        return OwnerResponse.builder()
                .id(ownerEntity.getId())
                .identityEntity(ownerEntity.getIdentityEntity())
                .firstName(ownerEntity.getFirstName())
                .middleName(ownerEntity.getMiddleName())
                .lastName(ownerEntity.getLastName())
                .primaryAddress(buildAddressResponse(ownerEntity.getPrimaryAddressEntity()))
                .PermanentAddress(buildAddressResponse(ownerEntity.getPermanentAddressEntity()))
                .order(ownerEntity.getOrder())
                .build();
    }

    private static AddressResponse buildAddressResponse(AddressEntity addressEntity) {
        return AddressResponse.builder()
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

    private static LocationResponse buildLocationResponse(LocationEntity locationEntity) {
        return LocationResponse.builder()
                .id(locationEntity.getId())
                .latitude(locationEntity.getLatitude())
                .longitude(locationEntity.getLongitude())
                .border(locationEntity.getBorder().stream().map(EntityToResponseMapper::buildLocationResponse).toList())
                .build();
    }

}
