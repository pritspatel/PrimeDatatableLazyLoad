import {SearchCriteria} from "./search.crtiteria.model";
export class CustomerSearchRequest{
    private offSet : number;
    private size : number;
    private sortField : string;
    private sortOrder  :string;
    private filters : SearchCriteria[];

    constructor(){}


    get _offSet(): number {
        return this.offSet;
    }

    set _offSet(value: number) {
        this.offSet = value;
    }

    get _size(): number {
        return this.size;
    }

    set _size(value: number) {
        this.size = value;
    }

    get _sortField(): string {
        return this.sortField;
    }

    set _sortField(value: string) {
        this.sortField = value;
    }

    get _sortOrder(): string {
        return this.sortOrder;
    }

    set _sortOrder(value: string) {
        this.sortOrder = value;
    }

    get _filters(): SearchCriteria[] {
        return this.filters;
    }

    set _filters(value: SearchCriteria[]) {
        this.filters = value;
    }
}