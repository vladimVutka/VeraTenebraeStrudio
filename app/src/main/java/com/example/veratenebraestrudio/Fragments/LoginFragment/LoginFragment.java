package com.example.veratenebraestrudio.Fragments.LoginFragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.example.veratenebraestrudio.Services.ApiService;
import com.example.veratenebraestrudio.Services.RetrofitClient;
import com.example.veratenebraestrudio.adapters.Users.OpenProfile;
import com.example.veratenebraestrudio.databinding.LoginLayoutBinding;

import DTOs.LoginDTO;
import DTOs.UserDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements OpenProfile
{
    private LoginLayoutBinding binding;

    private ApiService apiService = RetrofitClient.getApiService();

    private String usernael;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = LoginLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(View view, Bundle saveInstance){
        setUIElements();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.inputPassword.toString();
                String login = binding.inputLogin.toString();

                goToProfile(login, password);
            }
        };
        binding.loginButton.setOnClickListener(onClickListener);


        super.onViewCreated(view, saveInstance);
    }
    private void setUIElements(){
        ConstraintSet constraintSet = new ConstraintSet();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        constraintSet.clone(binding.loginLayout);
        //Фон с кодом
        constraintSet.connect(binding.codeImage.getId(), ConstraintSet.TOP, binding.loginLayout.getId(), ConstraintSet.TOP, 320);
        constraintSet.connect(binding.codeImage.getId(), ConstraintSet.START, binding.loginLayout.getId(), ConstraintSet.START, 0);
        constraintSet.connect(binding.codeImage.getId(), ConstraintSet.BOTTOM, binding.loginLayout.getId(), ConstraintSet.BOTTOM, 0);
        // Область с фоном ввода
        constraintSet.connect(binding.loginFieldView.getId(), ConstraintSet.TOP,binding.codeImage.getId(), ConstraintSet.TOP, 120);
        constraintSet.connect(binding.loginFieldView.getId(), ConstraintSet.START,binding.codeImage.getId(), ConstraintSet.START, displayMetrics.widthPixels/24);
        constraintSet.connect(binding.loginFieldView.getId(), ConstraintSet.END,binding.codeImage.getId(), ConstraintSet.END, displayMetrics.widthPixels/24);
        //Заголовок
        constraintSet.connect(binding.veraTenebrae.getId(), ConstraintSet.TOP, binding.loginLayout.getId(), constraintSet.TOP, 125);
        constraintSet.connect(binding.veraTenebrae.getId(), ConstraintSet.START, binding.loginLayout.getId(), constraintSet.START, displayMetrics.widthPixels/8);
        constraintSet.connect(binding.veraTenebrae.getId(), ConstraintSet.END, binding.loginLayout.getId(), constraintSet.END, displayMetrics.widthPixels/8);
        // Ввод данных
        constraintSet.connect(binding.inputLogin.getId(), ConstraintSet.TOP, binding.loginFieldView.getId(), constraintSet.TOP, 185);
        constraintSet.connect(binding.inputLogin.getId(), ConstraintSet.START, binding.loginFieldView.getId(), constraintSet.START, 25);
        constraintSet.connect(binding.inputLogin.getId(), ConstraintSet.END, binding.loginFieldView.getId(), constraintSet.END, 25);

        constraintSet.connect(binding.inputPassword.getId(), ConstraintSet.TOP, binding.loginFieldView.getId(), constraintSet.TOP, 315);
        constraintSet.connect(binding.inputPassword.getId(), ConstraintSet.START, binding.loginFieldView.getId(), constraintSet.START, 25);
        constraintSet.connect(binding.inputPassword.getId(), ConstraintSet.END, binding.loginFieldView.getId(), constraintSet.END, 25);
        //Кнопка входа
        constraintSet.connect(binding.loginButton.getId(), ConstraintSet.TOP, binding.loginFieldView.getId(), constraintSet.TOP, 445);
        constraintSet.connect(binding.loginButton.getId(), ConstraintSet.START, binding.loginFieldView.getId(), constraintSet.START, 25);
        constraintSet.connect(binding.loginButton.getId(), ConstraintSet.END, binding.loginFieldView.getId(), constraintSet.END, 25);
        //
        constraintSet.connect(binding.loginText.getId(), ConstraintSet.TOP, binding.loginFieldView.getId(), constraintSet.TOP, 445);
        constraintSet.connect(binding.loginText.getId(), ConstraintSet.START, binding.loginFieldView.getId(), constraintSet.START, 25);
        constraintSet.connect(binding.loginText.getId(), ConstraintSet.END, binding.loginFieldView.getId(), constraintSet.END, 25);

        Debug.logStack("disp","" + displayMetrics.widthPixels/12, 1);
        constraintSet.applyTo(binding.loginLayout);
    }

    public void goToProfile(String login, String password){
        LoginDTO loginDTO = new LoginDTO(login, password);
        Call<UserDTO> call = apiService.login(loginDTO);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if(response.isSuccessful()){
                    UserDTO user = response.body();
                    Debug.logStack("gyu", "yes", 1);
                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });
    }
}
