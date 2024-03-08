package riwi.devSync.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riwi.devSync.domain.service.ProfileService;
import riwi.devSync.persistence.entity.Profile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    @GetMapping("/profiles")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer id) {
        try {
            Profile profile = profileService.getProfileById(id);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/profile")
    public void saveProfile(@RequestBody Profile profile) {
        profileService.saveProfile(profile);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Integer id, @RequestBody Profile profile) {
        try {
            Profile currentProfile = profileService.getProfileById(id);
            currentProfile.setBio(profile.getBio());
            currentProfile.setPortfolio(profile.getPortfolio());
            currentProfile.setLocation(profile.getLocation());
            currentProfile.setNickname(profile.getNickname());

            profileService.saveProfile(currentProfile);
            return new ResponseEntity<Profile>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/profile/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable Integer id) {
        try {
            Profile profile = profileService.getProfileById(id);
            profileService.deleteProfile(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
