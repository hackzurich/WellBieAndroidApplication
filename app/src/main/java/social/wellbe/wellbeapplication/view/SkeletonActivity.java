package social.wellbe.wellbeapplication.view;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.mlsdk.common.LensEngine;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.mlsdk.skeleton.MLSkeleton;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzer;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzerFactory;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;

import social.wellbe.wellbeapplication.R;
import social.wellbe.wellbeapplication.SkeletonAnalyzerTransactor;

public class SkeletonActivity extends AppCompatActivity {
    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skeleton);
        surfaceView=findViewById(R.id.surface);

        MLSkeletonAnalyzer analyzer = MLSkeletonAnalyzerFactory.getInstance().getSkeletonAnalyzer();

        LensEngine lensEngine = new LensEngine.Creator(getApplicationContext(), analyzer)
                .setLensType(LensEngine.BACK_LENS)
                .applyDisplayDimension(1280, 720)
                .applyFps(20.0f)
                .enableAutomaticFocus(true)
                .create();

        Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {}
                    @Override public void onPermissionDenied(PermissionDeniedResponse response) { onBackPressed();}
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {}
                }).check();





        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lensEngine.run(surfaceView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}