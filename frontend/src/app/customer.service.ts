
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {Customer} from "./customer.model";

@Injectable()
export class CustomerService{

    private url = 'http://localhost:9999/api/customers';
    constructor(private _http  : Http){}

    getCustomers(offSet, pageSize, sortField, sortOrder, filterField, filterValue) : Observable<Customer[]>{
        let finalUrl = this.url + "/?page=" + offSet +"&size=" + pageSize + "&sortField=" + sortField +"&sortOrder=" + sortOrder + "&filterField=" + filterField + "&filterValue=" + filterValue;
        return this._http.get(finalUrl)
            .map((res:Response) => {
                let data = res.json();
                console.log('Data : ', data);
                return data;
            })
            //...errors if any
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getTotalRecords() : Observable<number>{
        let finalUrl = this.url +"/count";
        return this._http.get(finalUrl)
            .map((res:Response) => res.json())
            //...errors if any
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}