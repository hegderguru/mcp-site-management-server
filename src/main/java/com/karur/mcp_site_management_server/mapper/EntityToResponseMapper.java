package com.karur.mcp_site_management_server.mapper;

import com.karur.mcp_site_management_server.entity.*;
import com.karur.mcp_site_management_server.model.response.*;
import com.karur.mcp_site_management_server.util.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class EntityToResponseMapper {

    public static SiteResponse buildSiteResponse(SiteEntity siteEntity) {
        return SiteResponse.builder()
                .id(siteEntity.getId())
                .identifier(siteEntity.getIdentifier())
                .name(siteEntity.getName())
                .number(siteEntity.getNumber())
                .locationResponse(buildLocationResponse(siteEntity.getLocationEntity()))
                .addressResponse(buildAddressResponse(siteEntity.getAddressEntity()))
                .currentRegistrationResponse(buildRegistrationResponse(siteEntity.getCurrentRegistrationEntity()))
                .build();
    }

    private static RegistrationResponse buildRegistrationResponse(RegistrationEntity registrationEntity) {
        return RegistrationResponse.builder()
                .id(registrationEntity.getId())
                .identifier(registrationEntity.getIdentifier())
                .registrationDateTime(registrationEntity.getRegistrationDateTime())
                .currentOwnerResponses(CommonUtil.returnElseEmpty(registrationEntity.getCurrentOwnerEntities()).stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
                .siteResponses(CommonUtil.returnElseEmpty(registrationEntity.getSiteEntities()).stream().map(EntityToResponseMapper::buildSiteResponse).toList())
                .registrationAuditResponses(CommonUtil.returnElseEmpty(registrationEntity.getRegistrationAuditEntities()).stream().map(EntityToResponseMapper::buildRegistrationAuditResponse).toList())
                .build();
    }

    private static RegistrationAuditResponse buildRegistrationAuditResponse(RegistrationAuditEntity registrationAuditEntity) {
        return RegistrationAuditResponse.builder()
                .id(registrationAuditEntity.getId())
                .identifier(registrationAuditEntity.getIdentifier())
                .registrationDateTime(registrationAuditEntity.getRegistrationDateTime())
                .siteResponses(CommonUtil.returnElseEmpty(registrationAuditEntity.getSiteEntities()).stream().map(EntityToResponseMapper::buildSiteResponse).toList())
                .previousOwnerResponses(CommonUtil.returnElseEmpty(registrationAuditEntity.getPreviousOwnerEntities()).stream().map(EntityToResponseMapper::buildOwnerResponse).toList())
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
                .border(locationEntity.getBorder())
                .build();
    }

}
