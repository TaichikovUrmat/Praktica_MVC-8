package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {


    private final CompanyService companyService;

    @GetMapping
    public String getAllCompany(Model model){
      model.addAttribute("allCompany",companyService.findAllCompany());
        return "/companies";
    }
    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newCompany", new Company());
         return "/createNewCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company){
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/find/{companyId}")
    public String getById(Model model,@PathVariable("companyId") Long id){
        Company company = companyService.findCompanyById(id);
        model.addAttribute("companyID", id);
        model.addAttribute("companyInfo", company.getCourses());
        return "companyInnerPage";
    }


    @GetMapping ("/delete/{companyId}")
    public String deleteCompanyById(@PathVariable("companyId") Long companyId) {
        companyService.delete(companyId);
        return "redirect:/companies";
    }

    @GetMapping("/update/{companyId}")
    public String updateForm(@PathVariable("companyId") Long companyId,Model model){
        Company company = companyService.findCompanyById(companyId);
        model.addAttribute("company",company);
        return "updateCompany";
    }

    @PostMapping("/editUpdate/{companyId}")
    public String updateCompany(@ModelAttribute("company") Company company ,@PathVariable ("companyId")Long companyId){
        companyService.update(companyId,company);
        return "redirect:/companies";
    }



}
