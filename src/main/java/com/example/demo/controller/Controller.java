package com.example.demo.controller;


import com.example.demo.dto.PeakCreationRequest;
import com.example.demo.dto.PeakUpdateRequest;
import com.example.demo.entity.PeakEntity;
import com.example.demo.service.PeakService;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@org.springframework.stereotype.Controller
@AllArgsConstructor
@RequestMapping("/")
public class Controller {

    private final PeakService peakService;

    @RequestMapping(method = RequestMethod.GET, path = {"/"})
    public String showPeaksPage(Model model) {
        List<PeakEntity> peakEntityList = peakService.getAllPeaks();

        model.addAttribute("peakList", peakEntityList);
        PeakCreationRequest attributeValue = new PeakCreationRequest();

        model.addAttribute("peakToAdd", attributeValue);

        return "peaks";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String showAddPage(ModelMap model) {
        PeakCreationRequest attributeValue = new PeakCreationRequest();

        model.addAttribute("peakToAdd", attributeValue);

        return "addPeak";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@ModelAttribute(name = "peakToAdd") @Valid PeakCreationRequest request, BindingResult bindingResult,
                      Model model) {
        if(bindingResult.hasErrors()) {
            return "addPeak";
        }
        peakService.createPeak(request);
        return showPeaksPage(model);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{peakId}/edit")
    public String showEditPage(@PathVariable(name = "peakId") String id, Model model) {
        PeakEntity peakEntity = peakService.getPeakById(Integer.parseInt(id));
        model.addAttribute("peakToEdit", peakEntity);

        return "editPeak";

    }

    @PostMapping("/{peakID}/edit")
    public String editPeak(@PathVariable int peakID,
                           @ModelAttribute(name = "peakToEdit") @Valid PeakUpdateRequest request,
                           BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "editPeak";
        }
        request.setId(peakID);

        peakService.updatePeak(request);


        return showPeaksPage(model);
    }

    @PostMapping("/{peakid}/delete")
    public String deletePeak(@PathVariable int peakid,
                             Model model) {
        peakService.deletePeakById(peakid);

        return showPeaksPage(model);
    }


}
