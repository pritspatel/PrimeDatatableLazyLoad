export class SearchCriteria{

    private _name : string;
    private _value : string;

    constructor() {}


    get name(): string {
        return this._name;
    }

    set name(value: string) {
        this._name = value;
    }

    get value(): string {
        return this._value;
    }

    set value(value: string) {
        this._value = value;
    }
}