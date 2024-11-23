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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.project_mobile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemHealthServiceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imgHealthServiceIcon;

  @NonNull
  public final LinearLayout linearLayout7;

  @NonNull
  public final TextView txtHealthServiceName;

  private ItemHealthServiceBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imgHealthServiceIcon, @NonNull LinearLayout linearLayout7,
      @NonNull TextView txtHealthServiceName) {
    this.rootView = rootView;
    this.imgHealthServiceIcon = imgHealthServiceIcon;
    this.linearLayout7 = linearLayout7;
    this.txtHealthServiceName = txtHealthServiceName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemHealthServiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemHealthServiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_health_service, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemHealthServiceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgHealthServiceIcon;
      ImageView imgHealthServiceIcon = ViewBindings.findChildViewById(rootView, id);
      if (imgHealthServiceIcon == null) {
        break missingId;
      }

      id = R.id.linearLayout7;
      LinearLayout linearLayout7 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout7 == null) {
        break missingId;
      }

      id = R.id.txtHealthServiceName;
      TextView txtHealthServiceName = ViewBindings.findChildViewById(rootView, id);
      if (txtHealthServiceName == null) {
        break missingId;
      }

      return new ItemHealthServiceBinding((ConstraintLayout) rootView, imgHealthServiceIcon,
          linearLayout7, txtHealthServiceName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
