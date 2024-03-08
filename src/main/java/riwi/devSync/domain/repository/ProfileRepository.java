package riwi.devSync.domain.repository;

import riwi.devSync.persistence.entity.Profile;

import java.util.List;

public interface ProfileRepository {
    List<Profile> getAllProfiles();
    Profile getProfileById(Integer id);
    void saveProfile(Profile profile);
    void deleteProfile(Integer id);
}
