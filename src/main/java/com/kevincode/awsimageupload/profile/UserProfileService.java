package com.kevincode.awsimageupload.profile;

import com.kevincode.awsimageupload.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService){
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    @GetMapping
    List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }
    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file){
        // 1. Check if image is not empty
        // 2. Check if file is an image
        // 3. The user exists in our database
        // 4. Grab some metadata from file if any
        // 5. Store the image in s3 and update database with s3 image link
    }
}