import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export interface Student {
  id: number;
  type: string;
  model: string;
  price: string;
}

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Student[]> {
    return this.http.get<Student[]>('http://localhost:8000/products');
  }

  save(result: Student) {
    this.http.post('http://localhost:8000/products', result, {
      headers: {
        'Content-Type': 'application/json'
      }
    }).subscribe(result => console.log(result));
  }
}
