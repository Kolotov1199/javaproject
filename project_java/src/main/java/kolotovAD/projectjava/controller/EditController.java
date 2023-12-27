package kolotovAD.projectjava.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kolotovAD.projectjava.repository.SnRepository;
import kolotovAD.projectjava.entity.BascketMod;
import kolotovAD.projectjava.discriptions.bascketMod;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/bascket/")
@RequiredArgsConstructor
public class EditController {
    private final SnRepository bascketRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", bascketRepository.findAll());
        return "games";
    }

    @PostMapping("add")
    public String add(@Valid bascketMod request, BindingResult result, Model model) {
        System.out.println("sassasasasas");
        log.info("add artist request {}, binding result = {}", request, result.hasErrors());
        if (!result.hasErrors()) {
            bascketRepository.save(request.toEntity());
            return "redirect:/games/";
        } else {
            log.info("has errors: {}", result.getFieldErrors()
                    .stream()
                    .map(FieldError::getField)
                    .collect(Collectors.toList()));
        }
        return index(model);
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<BascketMod> game = bascketRepository.findById(id);
        game.ifPresent(value -> {
            model.addAttribute("gameDTO", value);
        });

        return "edit-game";
    }

    @PostMapping("edit")
    public String edit(@Valid bascketMod request, HttpServletRequest servletRequest, BindingResult result) {
        log.info("edit artist request {}, binding result = {}", request, result.hasErrors());
        if (!result.hasErrors()) {
            var artist = request.toEntity();
            bascketRepository.save(artist);
            return "redirect:/games/";
        } else {
            log.info("has errors: {}", result.getFieldErrors()
                    .stream()
                    .map(FieldError::getField)
                    .collect(Collectors.toList()));
        }
        return "edit-game";
    }

    @PostMapping("remove")
    public String remove(@Positive Long id) {
        bascketRepository.deleteById(id);
        return "redirect:/games/";
    }
}
