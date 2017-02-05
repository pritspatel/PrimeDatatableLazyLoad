import {Component, OnInit} from '@angular/core';
import {CustomerService} from "./customer.service";
import {Customer} from "./customer.model";
import {LazyLoadEvent, FilterMetadata} from "primeng/components/common/api";
import {PageRequest} from "./model/page.request.model";
import {Filter} from "./model/filter.model";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    title = 'Prime NG Datatable Lazy Load Demo';
    constructor(private custService: CustomerService) {
        /*custService.getTotalRecords().subscribe(count => {
                console.log('Getting total record counts....')
                this.totalRecords = count;
            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );*/
    }

    loadCustomersLazy(event: LazyLoadEvent) {
       /* console.log('Firing lazy load event...');
        console.log('event.first : %d', event.first);
        console.log('Event : ', event);


        //this.page = event.first/event.rows;
        let offSet = event.first;
        let orderBy = (event.sortOrder === 1 ? 'ASC' : 'DESC');
        let filterObj = event.filters;
        console.log('filter by : ', filterObj);
        console.log('firstName : ', filterObj['firstName']);
        let fieldName : string = '';
        let fieldValue : string = '';
        if(filterObj.hasOwnProperty('firstName')){
            fieldName = 'FIRST_NAME';
            fieldValue = filterObj['firstName']['value'];
            console.log('Name : ', fieldName);
            console.log('Value : ', fieldValue);
        }

        console.log('Building request object');
        let request : PageRequest = new PageRequest();
        request._offset = offSet;
        request._rows = event.rows;
        request._sortField = event.sortField;
        request._sortOrder = orderBy;
        let filter : Filter = new Filter();
        filter._fieldName = fieldName;
        filter._fieldValue = fieldValue;
        //request._filters[0] = filter;
        console.log("PageRequest : ", request);
        this.custService.getCustomers(offSet , event.rows, event.sortField, orderBy,fieldName,fieldValue).subscribe(
            customers => {
                console.log('Loading cars from backend....')
                this.customers = customers;
                if ((filterObj.hasOwnProperty('firstName')) && this.customers.length < this.totalRecords) {
                    this.totalRecords = this.customers.length;
                }else {
                    this.totalRecords = 100;
                }


            },
            err => {
                // Log errors if any
                console.log(err);
            }
        );*/
    }

    ngOnInit(): void {
       // this.page = 0;
    }
}
