package br.edu.iftm.adoteumpet.controler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class TratamentoDeExcecoes {

    @ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
    public String loginNameDuplicado(java.sql.SQLIntegrityConstraintViolationException ex,
            final RedirectAttributes redirectAttributes) {
        String errorMessage = ex.getMessage();
        if (errorMessage.contains("Duplicate entry")) {
            Pattern p = Pattern.compile("(?:^|\\s)'([^']*?)'(?:$|\\s)", Pattern.MULTILINE);
            Matcher m = p.matcher(errorMessage);
            m.find();
            m.find();
            redirectAttributes.addFlashAttribute("message", m.group().toLowerCase() + " duplicado. Cadastro não realizado! Tente novamente.");
            return "redirect:/form-usuario";
        }
        return "error";
    }
}
