import {SearchCriteria} from "./search.crtiteria.model";
export class CustomerSearchRequest{
    private _offSet : number;
    private _size : number;
    private _sortField : string;
    private _sortOrder  :string;
    private _filters : SearchCriteria[];

    constructor(){}


    get offSet(): number {
        return this._offSet;
    }

    set offSet(value: number) {
        this._offSet = value;
    }

    get size(): number {
        return this._size;
    }

    set size(value: number) {
        this._size = value;
    }

    get sortField(): string {
        return this._sortField;
    }

    set sortField(value: string) {
        this._sortField = value;
    }

    get sortOrder(): string {
        return this._sortOrder;
    }

    set sortOrder(value: string) {
        this._sortOrder = value;
    }

    get filters(): SearchCriteria[] {
        return this._filters;
    }

    set filters(value: SearchCriteria[]) {
        this._filters = value;
    }
}