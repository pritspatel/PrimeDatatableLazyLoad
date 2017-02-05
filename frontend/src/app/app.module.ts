import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {CustomerService} from "./customer.service";
import {DataTableModule} from "primeng/components/datatable/datatable";
import {PaginatorModule} from "primeng/components/paginator/paginator";
import { CustomerListComponent } from './customer-list/customer-list.component';
import {CustomerSearchService} from "./customer-list/customer-search.service";

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
      DataTableModule,
      PaginatorModule
  ],
  providers: [CustomerService,CustomerSearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
