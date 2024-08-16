import { Component } from "@angular/core";

@Component({
    selector:'app-single',
    // template: '<h1>template</h1>',
    template: `<h1>Registration Form</h1> <br><br>
    <form>
        <div>
            <div class="form-group">
                <label for="emailControl">Email Id :</label>
                <input type="text" id="emailControl" class="form-control"><br>
            </div>
            <div class="form-group">
                <label for="passwordControl">Password :</label>
                <input type="text" id="passwordControl" class="form-control"><br><br>
            </div>
        </div>
        <br>
        <!-- <pre>
        <button class="btn btn-success">Submit</button>    <button class="btn btn-info">Clear</button>
    </pre> -->
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button
            class="btn btn-success">Submit</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info">Clear</button>
        <br><br>
    </form>`,
    styles : ['h1 {color:green;}']
})
export class SingleComponent {

}