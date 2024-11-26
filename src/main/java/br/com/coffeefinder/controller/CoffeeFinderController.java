package br.com.coffeefinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffee-finder")
public class CoffeeFinderController {

	// private final ProductService productService;
	// private final MerchantService merchantService;

	// public CoffeeFinderController(ProductService productService, MerchantService merchantService) {
	//     this.productService = productService;
	//     this.merchantService= merchantService;
	// }

	// @GetMapping
	// public String showProducts(Model model) {
	//     model.addAttribute("products", productService.getAllProducts());
	//     model.addAttribute("merchants", merchantService.getAllMerchants());
	//     return "coffee-finder/index";
	// }

	// @GetMapping("/products/new")
	// public String showProductForm(Model model) {
	//     model.addAttribute("product", new Product());
	//     model.addAttribute("merchants", merchantService.getAllMerchants());
	//     return "coffee-finder/product-form";
	// }

	// @PostMapping("/products")
	// public String saveProduct(@Valid Product product, BindingResult result) {
	//     if (result.hasErrors()) {
	//         return "coffee-finder/product-form";
	//     }
	//     productService.createProduct(product);
	//     return "redirect:/coffee-finder";
	// }

	// @GetMapping("/products/{id}/edit")
	// public String showEditForm(@PathVariable Long id, Model model) throws ResourceNotFoundException {
	//     model.addAttribute("product", productService.getProductById(id));
	//     model.addAttribute("merchants",merchantService.getAllMerchants());
	//     return "coffee-finder/product-form";
	// }

}
