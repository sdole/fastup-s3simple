package fastup.training;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by sachi_000 on 1/14/2017.
 */
public class S3Upload {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        0. Select API/Product
        1. Get Credentials
        2. Create A Request
        3. Execute
         */

        final ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("fastup-training");
        AmazonS3Client s3Client = new AmazonS3Client(credentialsProvider);

        final BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\tmp\\afile.txt"));

        final ObjectMetadata metadata = new ObjectMetadata();
        metadata.addUserMetadata("akey", "avalue");
        final PutObjectRequest putObjectRequest = new PutObjectRequest("fastup-training-exercise", "test/root/child/file.txt", bufferedInputStream, metadata);


        s3Client.putObject(putObjectRequest);
    }
}
