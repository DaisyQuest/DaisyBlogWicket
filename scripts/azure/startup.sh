#!/usr/bin/env bash
set -euo pipefail

APP_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TOMEE_HOME="$APP_ROOT/apache-tomee-plus-10.1.5"
HTTP_PORT="${PORT:-${WEBSITES_PORT:-80}}"

if [ ! -d "$TOMEE_HOME" ]; then
    echo "TomEE home was not found at $TOMEE_HOME" >&2
    exit 1
fi

chmod +x "$TOMEE_HOME"/bin/*.sh || true

sed -i "s/port=\"8080\" protocol=\"HTTP\\/1.1\"/port=\"$HTTP_PORT\" protocol=\"HTTP\\/1.1\"/" "$TOMEE_HOME/conf/server.xml"

export CATALINA_HOME="$TOMEE_HOME"
export CATALINA_BASE="$TOMEE_HOME"
export JAVA_OPTS="${JAVA_OPTS:-} -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true"

exec "$TOMEE_HOME/bin/catalina.sh" run
