package kolotovAD.projectjava.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import kolotovAD.projectjava.repository.UserRepository;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping()
    public String index(org.springframework.ui.Model model) {
        model.addAttribute("links", Map.of(
                "Модели", "model/",
                "Страна", "country/",
                "Магазин", "shop/",
                "Регистрация", "register/"

        ));
        return "index";
    }


}

