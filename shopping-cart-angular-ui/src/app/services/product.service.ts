import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Product {
  id: number;
  type: string;
  model: string;
  price: string;
}

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8081/products');
  }

  save(result: Product) {
    this.http.post('http://localhost:8081/products', result, {
      headers: {
        'Content-Type': 'application/json'
      }
    }).subscribe(result => console.log(result));
  }
}
