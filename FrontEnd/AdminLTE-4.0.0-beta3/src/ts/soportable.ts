export function setupSortable(): void {
  const connectedSortables = document.querySelectorAll(".connectedSortable");
  connectedSortables.forEach((connectedSortable) => {
    // @ts-ignore - Sortable puede no estar definido en TypeScript
    new Sortable(connectedSortable, {
      group: "shared",
      handle: ".card-header",
    });
  });

  const cardHeaders = document.querySelectorAll(".connectedSortable .card-header");
  cardHeaders.forEach((cardHeader) => {
    cardHeader.style.cursor = "move";
  });
}