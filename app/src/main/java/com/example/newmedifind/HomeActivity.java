package com.example.newmedifind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    ImageView Logoimage;
    ImageView Ad1, Ad2 , Ad3,Popular1,Popular2,Popular3,Popular4,Popular5,Popular6 ;
    TextView Greetings,Popular;
    TextInputLayout Search;
    TextInputEditText Search1;
    Button Loginback;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intia();
        Listeners();

        Intent intent = getIntent();
        String UsernameDisplay = "Greetings"+" "+ intent.getStringExtra("username");
        Greetings.setText(UsernameDisplay);



        storageReference= FirebaseStorage.getInstance().getReference().child("Crocine Advanced Tablet.jpg");

        try {
            final File localFile=File.createTempFile("Crocine Advanced Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular1.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }


        storageReference= FirebaseStorage.getInstance().getReference().child("Dolo Tablet.jpg");
        try {
            final File localFile=File.createTempFile("Dolo Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular2.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        storageReference= FirebaseStorage.getInstance().getReference().child("Meftal Spas Tablet.jpg");
        try {
            final File localFile=File.createTempFile("Meftal Spas Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular3.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        storageReference= FirebaseStorage.getInstance().getReference().child("Okacet Tablet.jpg");

        try {
            final File localFile=File.createTempFile("Okacet Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular4.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        storageReference= FirebaseStorage.getInstance().getReference().child("Cyclopam Tablet.jpg");
        try {
            final File localFile=File.createTempFile("Cyclopam Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular5.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        storageReference= FirebaseStorage.getInstance().getReference().child("Metzok Tablet.jpg");
        try {
            final File localFile=File.createTempFile("Metzok Tablet","jpg");

            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            Popular6.setImageBitmap(bitmap);

                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void Listeners(){


        Search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,SerachTab.class);
                startActivity(intent);
            }
        });


        Popular1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Crocin0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        Popular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Dolo0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        Popular3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Meftal0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        Popular4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Okacet0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        Popular5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Cyclopam0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        Popular6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("MedicineDetails").child("Metzok0");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String medicinename=snapshot.child("medicinename").getValue().toString();
                        String id= snapshot.getKey();

                        Intent intent=new Intent(HomeActivity.this,MedicinedetailActivity.class);
                        intent.putExtra("id",id);
                        intent.putExtra("medicinename",medicinename);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });




    }




    private void intia(){
        Greetings=findViewById(R.id.greeting);
        Search=findViewById(R.id.search_bar);
        Search1=findViewById(R.id.search_bar1);
        Ad1=findViewById(R.id.imageView1);
        Ad2=findViewById(R.id.imageView2);
        Ad3=findViewById(R.id.imageView3);
        Popular1=findViewById(R.id.imageView4);
        Popular2=findViewById(R.id.imageView5);
        Popular3=findViewById(R.id.imageView6);
        Popular4=findViewById(R.id.imageView7);
        Popular5=findViewById(R.id.imageView8);
        Popular6=findViewById(R.id.imageView9);

    }
}