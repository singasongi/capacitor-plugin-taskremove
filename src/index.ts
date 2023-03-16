import { registerPlugin } from '@capacitor/core';

import type { TaskRemovePlugin } from './definitions';

const TaskRemove = registerPlugin<TaskRemovePlugin>('TaskRemove', {
  web: () => import('./web').then(m => new m.TaskRemoveWeb()),
});

export * from './definitions';
export { TaskRemove };
