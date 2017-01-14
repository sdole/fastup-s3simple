package fastup.training;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Created by sachi_000 on 1/14/2017.
 */
public class S3Create {

    public static void main(String[] args) {
        /*
        0. Select API/Product
        1. Get Credentials
        2. Create A Request
        3. Execute
         */

        final ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("fastup-training");
        AmazonS3Client s3Client = new AmazonS3Client(credentialsProvider);
        s3Client.createBucket("fastup-training-exercise");
    }
}
