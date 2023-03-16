import { WebPlugin } from '@capacitor/core';

import type { TaskRemovePlugin } from './definitions';

export class TaskRemoveWeb extends WebPlugin implements TaskRemovePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
