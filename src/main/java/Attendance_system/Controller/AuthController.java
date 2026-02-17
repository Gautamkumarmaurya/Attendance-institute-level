package Attendance_system.Controller;

import Attendance_system.DTO.Auth.AuthResponse;
import Attendance_system.DTO.Auth.LoginRequest;
import Attendance_system.DTO.Auth.RegisterRequest;
import Attendance_system.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

        private final AuthService authService;


        @PostMapping("/register")
        public String register(@RequestBody RegisterRequest request){
            return authService.register(request);
        }

        @PostMapping("/login")
        public AuthResponse login(@RequestBody LoginRequest request){
            return authService.login(request);
        }
}

