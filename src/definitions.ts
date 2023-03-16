export interface TaskRemovePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
