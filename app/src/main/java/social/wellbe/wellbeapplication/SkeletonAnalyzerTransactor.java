package social.wellbe.wellbeapplication;


import android.util.Log;
import android.util.SparseArray;

import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.skeleton.MLSkeleton;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzer;
import com.huawei.hms.mlsdk.skeleton.MLSkeletonAnalyzerFactory;

import java.util.ArrayList;
import java.util.List;

public class SkeletonAnalyzerTransactor implements MLAnalyzer.MLTransactor<MLSkeleton> {
    MLSkeletonAnalyzer analyzer = MLSkeletonAnalyzerFactory.getInstance().getSkeletonAnalyzer();
    List<MLSkeleton> temp;

    @Override
    public void transactResult(MLAnalyzer.Result<MLSkeleton> results) {
        SparseArray<MLSkeleton> items = results.getAnalyseList();
        // You can process the recognition result as required. For example, calculate the similarity in this method, so as to perform an operation such as taking a photo after a specific posture is detected.
        // Note that only the detection result is processed. Other detection APIs provided by ML Kit cannot be called.
        // Convert the result encapsulated using SparseArray to an ArrayList for similarity calculation.
        List<MLSkeleton> resultsList = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            resultsList.add(items.valueAt(i));
            Log.d("Mahmoud",items.valueAt(i).toString());
        }
        // Calculate the similarity between the detection result and template.
        // templateList is a list of skeleton templates. Templates can be generated through static image detection. The skeleton detection service supports single-person and multi-person template matching.
    }
    @Override
    public void destroy() {
        // Callback method used to release resources when the detection ends.
    }
}