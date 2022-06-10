package com.kevincode.awsimageupload.profile;

import com.kevincode.awsimageupload.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Repository
public class UserProfileDataAccessService {

    private final FakeUserProfileDataStore fakeUserProfileDataStore;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileDataStore fakeUserProfileDataStore) {
        this.fakeUserProfileDataStore = fakeUserProfileDataStore;
    }

    List<UserProfile> getUserProfiles() {
        return fakeUserProfileDataStore.getUserProfiles();
    }

}
