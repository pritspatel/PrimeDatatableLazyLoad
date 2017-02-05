
import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {CustomerSearchRequest} from "../model/customer.search.request.model";
import {Observable} from "rxjs";
import {CustomerSearchResponse} from "../model/customer-search-response.model";

@Injectable()
export class CustomerSearchService{

    private searchUrl : string = "http://localhost:9999/api/customers/search/";

    constructor(private _http: Http){}

    searchCustomer(searchRequest : CustomerSearchRequest) : Observable<any>{
        console.log('Sending search request : ', searchRequest);
        let bodyString = JSON.stringify(searchRequest); // Stringify payload
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers }); // Create a request option

        return this._http.post(this.searchUrl, bodyString,options)
            .map((res:Response) => res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}