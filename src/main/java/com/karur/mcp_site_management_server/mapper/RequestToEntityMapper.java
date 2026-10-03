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
                .build();
    }

    private static RegistrationEntity buildRegistration(RegistrationRequest registrationRequest) {
        return RegistrationEntity.builder()
                .id(registrationRequest.getId())
                .identifier(registrationRequest.getIdentifier())
                .registrationDateTime(registrationRequest.getRegistrationDateTime())
                .build();
    }

    private static OwnerEntity buildOwner(OwnerRequest ownerRequest) {
        return OwnerEntity.builder()
                .id(ownerRequest.getId())
                .firstName(ownerRequest.getFirstName())
                .middleName(ownerRequest.getMiddleName())
                .email(ownerRequest.getEmail())
                .phone(ownerRequest.getPhone())
                .panCard(ownerRequest.getPanCard())
                .aadhar(ownerRequest.getAadhar())
                .idNameAndValue(ownerRequest.getIdNameAndValue())
                .orgRegNumber(ownerRequest.getOrgRegNumber())
                .lastName(ownerRequest.getLastName())
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
                .longitudeAndLatitude(locationRequest.getLongitudeAndLatitude())
                .border(locationRequest.getBorder())
                .build();
    }


    public static SiteEntity buildCompleteSite(SiteRequest siteRequest) {
        return SiteEntity.builder()
                .id(siteRequest.getId())
                .identifier(siteRequest.getIdentifier())
                .name(siteRequest.getName())
                .number(siteRequest.getNumber())
                .locationEntity(buildCompleteLocation(siteRequest.getLocationRequest()))
                .addressEntity(buildCompleteAddress(siteRequest.getAddressRequest()))
                .currentRegistrationEntity(buildCompleteRegistration(siteRequest.getCurrentRegistrationRequest()))
                .build();
    }

    private static RegistrationEntity buildCompleteRegistration(RegistrationRequest registrationRequest) {
        return RegistrationEntity.builder()
                .id(registrationRequest.getId())
                .identifier(registrationRequest.getIdentifier())
                .registrationDateTime(registrationRequest.getRegistrationDateTime())
                .currentOwnerEntities(CommonUtil.returnElseEmpty(registrationRequest.getCurrentOwnerRequests()).stream().map(RequestToEntityMapper::buildCompleteOwner).toList())
                .siteEntities(CommonUtil.returnElseEmpty(registrationRequest.getSiteRequests()).stream().map(RequestToEntityMapper::buildCompleteSite).toList())
                .build();
    }

    private static OwnerEntity buildCompleteOwner(OwnerRequest ownerRequest) {
        return OwnerEntity.builder()
                .id(ownerRequest.getId())
                .firstName(ownerRequest.getFirstName())
                .middleName(ownerRequest.getMiddleName())
                .lastName(ownerRequest.getLastName())
                .email(ownerRequest.getEmail())
                .phone(ownerRequest.getPhone())
                .aadhar(ownerRequest.getAadhar())
                .panCard(ownerRequest.getPanCard())
                .idNameAndValue(ownerRequest.getIdNameAndValue())
                .primaryAddressEntity(buildCompleteAddress(ownerRequest.getPrimaryAddress()))
                .permanentAddressEntity(buildCompleteAddress(ownerRequest.getPermanentAddress()))
                .order(ownerRequest.getOrder())
                .build();
    }

    private static AddressEntity buildCompleteAddress(AddressRequest addressRequest) {
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

    private static LocationEntity buildCompleteLocation(LocationRequest locationRequest) {
        return LocationEntity.builder()
                .id(locationRequest.getId())
                .longitudeAndLatitude(locationRequest.getLongitudeAndLatitude())
                .border(locationRequest.getBorder())
                .build();
    }

}
