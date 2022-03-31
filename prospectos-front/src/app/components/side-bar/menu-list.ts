export class MenuItem {
    constructor(
        public name: string,
        public route: string,
        public toolTip: string,
        public icon: string = ''
    ) {}
}

export const menuList = [
    new MenuItem('Listado de Prospectos', 'listado_prospectos', 'Listado de Prospectos', 'list'),
    new MenuItem('Capturar Prospectos', 'captura_prospecto', 'Capturar Prospectos', 'add_circle_outline'),
    new MenuItem('Evaluar Prospectos', 'evaluacion_prospectos', 'Evaluar Prospectos', 'how_to_vote'),
];
