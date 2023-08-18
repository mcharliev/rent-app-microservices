package com.example.rentflatsharing.controller;

import com.example.rentflatsharing.model.dto.AddressDto;
import com.example.rentflatsharing.service.impl.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("address")
public class AddressController {
    private final AddressServiceImpl addressService;

    @PatchMapping("/{adId}")
    public ResponseEntity<AddressDto> editApartment(@PathVariable("adId") Long adId,
                                                    @RequestPart AddressDto addressDto) {
        return ResponseEntity.ok(addressService.editAddress(adId, addressDto));
    }

    @PostMapping
    ResponseEntity<AddressDto> addApartment(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.addAddress(addressDto));
    }

    @DeleteMapping("/{adId}")
    public void deleteAddress(@PathVariable Long adId) {
        addressService.deleteAddress(adId);
    }

    @GetMapping("/{adId}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Long adId) {
        return ResponseEntity.ok(addressService.getAddress(adId));
    }
}
