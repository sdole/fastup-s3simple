package fastup.training;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

import java.io.FileNotFoundException;

/**
 * Created by sachi_000 on 1/14/2017.
 */
public class S3Download {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        0. Select API/Product
        1. Get Credentials
        2. Create A Request
        3. Execute
         */

        final ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider("fastup-training");
        AmazonS3Client s3Client = new AmazonS3Client(credentialsProvider);


        final GetObjectRequest getObjectRequest = new GetObjectRequest("fastup-training-exercise","test/root/child/file.txt");
        final S3Object s3ClientObject = s3Client.getObject(getObjectRequest);
        final S3ObjectInputStream objectContent = s3ClientObject.getObjectContent();
    }
}
