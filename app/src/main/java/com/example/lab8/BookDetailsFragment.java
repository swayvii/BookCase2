package com.example.lab8;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {

    public BookDetailsFragment() {
        // Required empty public constructor
    }

    private TextView textView;
    private ImageView imageView;
    private String title;
    private String author;
    private String publish;
    private static final String BOOK_KEY = "myBook";
    private Book book;

    public static BookDetailsFragment newInstance(Book bookList) {
        BookDetailsFragment fragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BOOK_KEY, bookList);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            book = getArguments().getParcelable(BOOK_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);
        textView = view.findViewById(R.id.bookTitle);
        imageView = view.findViewById(R.id.bookImage);
        if (getArguments() != null) {
            displayBook(book);
        }

        return view;
    }

    public void displayBook(Book bookObj) {
        author = bookObj.getAuthor();
        title = bookObj.getTitle();
        publish = bookObj.getPublished();
        textView.setText(" \"" + title + "\" ");
        textView.append(" " + author);
        textView.append(" " + publish);

        String imageURL = bookObj.getCoverURL();
        Picasso.get().load(imageURL).into(imageView);
    }


}
