// Generated by view binder compiler. Do not edit!
package com.example.project_mobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.project_mobile.R;
import com.example.project_mobile.SearchBarView;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBlogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final SearchBarView searchBar;

  @NonNull
  public final TextView textView9;

  @NonNull
  public final ShapeableImageView useAvatar;

  private FragmentBlogBinding(@NonNull ConstraintLayout rootView, @NonNull SearchBarView searchBar,
      @NonNull TextView textView9, @NonNull ShapeableImageView useAvatar) {
    this.rootView = rootView;
    this.searchBar = searchBar;
    this.textView9 = textView9;
    this.useAvatar = useAvatar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBlogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBlogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_blog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBlogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.searchBar;
      SearchBarView searchBar = ViewBindings.findChildViewById(rootView, id);
      if (searchBar == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      id = R.id.useAvatar;
      ShapeableImageView useAvatar = ViewBindings.findChildViewById(rootView, id);
      if (useAvatar == null) {
        break missingId;
      }

      return new FragmentBlogBinding((ConstraintLayout) rootView, searchBar, textView9, useAvatar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
