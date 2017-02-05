
import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {CustomerSearchRequest} from "../model/customer.search.request.model";
import {Observable} from "rxjs";
import {CustomerSearchResponse} from "../model/customer-search-response.model";

@Injectable()
export class CustomerSearchService{

    private searchUrl : string = "http://localhost:9999/api/customers/search";

    constructor(private _http: Http){}

    searchCustomer(searchRequest : CustomerSearchRequest) : Observable<CustomerSearchResponse>{
        console.log('Sending search request : ', searchRequest);
        return this._http.get(this.searchUrl)
            .map((res:Response) => res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}