// Generated by view binder compiler. Do not edit!
package com.example.project_mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.project_mobile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class HealthServicesBottomSheetBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView cancelButton;

  @NonNull
  public final TextView createText;

  @NonNull
  public final RecyclerView healthServicesRecyclerView;

  private HealthServicesBottomSheetBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView cancelButton, @NonNull TextView createText,
      @NonNull RecyclerView healthServicesRecyclerView) {
    this.rootView = rootView;
    this.cancelButton = cancelButton;
    this.createText = createText;
    this.healthServicesRecyclerView = healthServicesRecyclerView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HealthServicesBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HealthServicesBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.health_services_bottom_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HealthServicesBottomSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancelButton;
      ImageView cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.createText;
      TextView createText = ViewBindings.findChildViewById(rootView, id);
      if (createText == null) {
        break missingId;
      }

      id = R.id.healthServicesRecyclerView;
      RecyclerView healthServicesRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (healthServicesRecyclerView == null) {
        break missingId;
      }

      return new HealthServicesBottomSheetBinding((LinearLayout) rootView, cancelButton, createText,
          healthServicesRecyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
