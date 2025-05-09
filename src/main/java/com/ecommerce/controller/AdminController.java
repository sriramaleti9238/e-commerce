package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

    @Autowired
    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/login")
    public String loginPage(Model model, HttpServletRequest request) {
        model.addAttribute("currentPath", "/admin/login");
        return "admin/login";
    }

    @GetMapping("/products")
    public String listProducts(Model model, HttpServletRequest request) {
        List<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("currentPath", "/admin/products");
        return "admin/products";
    }

    @GetMapping("/products/new")
    public String showProductForm(Model model, HttpServletRequest request) {
        model.addAttribute("product", new Product());
        model.addAttribute("isNew", true);
        model.addAttribute("currentPath", "/admin/products/new");
        return "admin/product-form";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model, HttpServletRequest request) {
        Optional<Product> product = productService.findProductById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("isNew", false);
            model.addAttribute("currentPath", "/admin/products/edit/" + id);
            return "admin/product-form";
        } else {
            return "redirect:/admin/products";
        }
    }

    @PostMapping("/products/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result,
                              RedirectAttributes redirectAttributes,
                              Model model,
                              HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("isNew", product.getId() == null);
            model.addAttribute("currentPath", "/admin/products/save");
            return "admin/product-form";
        }

        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("successMessage",
                product.getId() == null ? "Product created successfully!" : "Product updated successfully!");

        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (productService.deleteProduct(id)) {
            redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product!");
        }

        return "redirect:/admin/products";
    }
}