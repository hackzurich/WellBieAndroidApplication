package social.wellbe.wellbeapplication.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.mlsdk.skeleton.MLSkeleton;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzer;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzerFactory;

import java.io.IOException;
import java.util.List;

import social.wellbe.wellbeapplication.R;

public class SkeletonActivity extends AppCompatActivity {
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skeleton);
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 505);

        MLSkeletonAnalyzer analyzer = MLSkeletonAnalyzerFactory.getInstance().getSkeletonAnalyzer();


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MLFrame frame = MLFrame.fromBitmap(bitmap);
                Task<List<MLSkeleton>> task = analyzer.asyncAnalyseFrame(frame);
                task.addOnSuccessListener(new OnSuccessListener<List<MLSkeleton>>() {
                    @Override
                    public void onSuccess(List<MLSkeleton> results) {
                        // Detection success.
                        Log.i("success", results.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        // Detection failure.
                        Log.i("success", e.toString());
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (intent != null) {
            // Get the URI of the selected file
            final Uri uri = intent.getData();
            try {
                useImage(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }


            super.onActivityResult(requestCode, resultCode, intent);

        }
    }

    void useImage(Uri uri) throws IOException {
        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        //use the bitmap as you like

    }


}