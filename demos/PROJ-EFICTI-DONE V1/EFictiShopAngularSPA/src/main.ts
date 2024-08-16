import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}
//platformBrowserDynamic - compilation and execution of Angular apps on different supported browsers.
// bootstrapModule(AppModule) - loads AppModule
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
