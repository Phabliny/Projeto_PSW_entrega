package br.edu.iftm.adoteumpet.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.adoteumpet.beans.UsuarioBean;

@Controller
public class Controlador {

    @Autowired
    UsuarioBean usuarioBean;

    // @GetMapping(value = "home")
    // public String home() {
    // return "home";
    // }

    @GetMapping(value = { "/", "/home" })
    public String refererPage() {
        System.out.println();
        System.out.println();
        System.out.println("---------------------->" + usuarioBean.getURL());

        if (usuarioBean.getURL() == null)
            return "home";
        String retorno = "redirect:" + usuarioBean.getURL();
        usuarioBean.setURL(null);
        return retorno;
    }

    @GetMapping(value = "/perfil")
    public String perfil() {
        return "perfil";
    }

    @GetMapping(value = "/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/apoio")
    public String apoio() {
        return "apoio";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if (request.getHeader("Referer") != null) {
            String url = request.getHeader("Referer").substring(21);
            System.out.println();
            System.out.println();
            System.out.println("----------------------> Setando URL: " + url);
            if (url.equals("/adote")) {
                usuarioBean.setURL(url);
            }
        }
        return "login";
    }

}
