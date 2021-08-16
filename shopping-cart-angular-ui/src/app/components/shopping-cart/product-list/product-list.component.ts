import {Component, OnDestroy, OnInit} from '@angular/core';

import {ProductsService} from 'src/app/services/product.service';
import {Product} from 'src/app/models/product';
import {WishlistService} from 'src/app/services/wishlist.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  productList: Product[] = [];
  wishlist: number[] = [];

  constructor(
    private productService: ProductsService,
    private wishlistService: WishlistService,
  ) {
  }

  ngOnInit() {
    this.loadProducts();
    this.loadWishlist();
  }

  loadProducts() {
    this.productService.getAll().subscribe((products) => {
      // @ts-ignore
      this.productList = products;
    });
  }

  loadWishlist() {
    this.wishlistService.getWishlist().subscribe(productIds => {
      this.wishlist = productIds;
    });
  }
}
