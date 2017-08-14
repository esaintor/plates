package guru.springframework.controllers;

import guru.springframework.domain.Plate;
import guru.springframework.services.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlateController {

    private PlateService plateService;

    @Autowired
    public void setPlateService(PlateService plateService) {
        this.plateService = plateService;
    }

    @RequestMapping(value = "/plates", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("plates", plateService.listAllPlates());
        System.out.println("Returning rpoducts:");
        return "plates";
    }

    @RequestMapping("plate/{id}")
    public String showPlate(@PathVariable Integer id, Model model){
        model.addAttribute("plate", plateService.getPlateById(id));
        return "plateshow";
    }

    @RequestMapping("plate/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("plate", plateService.getPlateById(id));
        return "plateform";
    }

    @RequestMapping("plate/new")
    public String newPlate(Model model){
        model.addAttribute("plate", new Plate());
        return "plateform";
    }

    @RequestMapping(value = "plate", method = RequestMethod.POST)
    public String savePlate(Plate plate){
        System.err.println("--dd--");
        System.err.println(plate);
        plateService.savePlate(plate);

        return "redirect:/plate/" + plate.getId();
    }

}
